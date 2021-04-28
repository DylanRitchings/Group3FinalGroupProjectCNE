import React, { useState } from 'react';
import { CardModal } from './cardModal';
import { CreateTicketModal } from './createTicketModal';
import ReactPaginate from 'react-paginate';
import axios from 'axios';

import CardStructure from './cardStructure';
import './Tickets.css';
import { UpdateTicketModal } from './updateTicketModal';


const QueuedTickets = ({ tickets, setTickets }) => {

    const [showCreateTicketModal, setShowCreateTicketModal] = useState(false);
    const [showUpdateTicketModal, setShowUpdateTicketModal] = useState(false);
    const [showTicketModal, setShowTicketModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);
    const [ticketDescription, setTicketDescription] = useState('');
    const [ticketTitle, setTicketTitle] = useState('');
    const [pageNum, setPageNum] = useState(1);
    const [createdTicket, setCreatedTicket] = useState("");


    const QueuedTicketsList = [];
    tickets.map((ticket) => {
        if (ticket.complete === false) {
            QueuedTicketsList.push(ticket);
            console.log('queued tickets: ', QueuedTicketsList);
        }
    })

    const numOfTickets = QueuedTicketsList.length;
    const ticketsPerPage = 4;
    const firstTicketToDisplay = ((pageNum - 1) * ticketsPerPage) + 1;

    // eg. user clicks page 2 button, we want tickets 5-8 to display.
    const displayTickets = QueuedTicketsList.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const numOfPages = Math.ceil(numOfTickets / ticketsPerPage);


    const openTicketModal = (ticketDetails) => {
        setShowTicketModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
    }

    const openCreateTicketModal = () => {
        setShowCreateTicketModal(prev => !prev);
    }

    const openUpdateTicketModal = (ticketDetails) => {
        setShowUpdateTicketModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
        setTicketDescription(ticketDetails.description);
        setTicketTitle(ticketDetails.title);
    }

    const updateTicketToCompleted = (cardStuff) => {
        
                axios.put(`http://localhost:8901/tickets/update/${cardStuff.id}`, {
                    complete: true,
                    name: cardStuff.name,
                    description: cardStuff.description,
                    title: cardStuff.title,
                    createdAt: cardStuff.createdAt
                })
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log(error);
                    })

    }

    const updateTicketContents = ({ ticketDescription, ticketTitle, currentTicketModal }) => {
       
                axios.put(`http://localhost:8901/tickets/update/${currentTicketModal.id}`, {
                    complete: currentTicketModal.complete,
                    name: currentTicketModal.name,
                    description: ticketDescription,
                    title: ticketTitle,
                    
                })
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log(error);
                    })

    }


    const createNewTicket = ({ name, ticketDescription, ticketTitle }) => {

        axios.post(`http://localhost:8901/tickets/create`, {
            complete: false,
            name: name,
            description: ticketDescription,
            title: ticketTitle,
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })

    }

   
    const deleteTicket = (id) => {
        axios.delete(`http://localhost:8901/tickets/delete/${id}`)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })



    }

    const changePage = ({ selected }) => {
        setPageNum(selected + 1);
        console.log('updated list with new ticket: ', tickets);
    }


    return (
        <>
            <div className="queuedHeading">
                <h2 className="header" id="create-ticket">Queued Tickets</h2>
                <button className="btnCreate" id="create-ticket" onClick={openCreateTicketModal}>
                    Create Ticket
			</button>

            </div>
            <div className="cardGrid">
                {
                    // tickets.filter(ticket => ticket.complete === false)
                    displayTickets.map((cardStuff) => (
                        <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal} deleteTicket={deleteTicket} updateTicketToCompleted={updateTicketToCompleted} openUpdateTicketModal={openUpdateTicketModal} />
                    ))

                }
                <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal} currentTicketModal={currentTicketModal} />
                <CreateTicketModal showCreateTicketModal={showCreateTicketModal} setShowCreateTicketModal={setShowCreateTicketModal} createNewTicket={createNewTicket} tickets={tickets} />
                <UpdateTicketModal showUpdateTicketModal={showUpdateTicketModal} setShowUpdateTicketModal={setShowUpdateTicketModal} updateTicketContents={updateTicketContents} currentTicketModal={currentTicketModal} setCurrentTicketModal={setCurrentTicketModal} ticketDescription={ticketDescription} setTicketDescription={setTicketDescription} ticketTitle={ticketTitle} setTicketTitle={setTicketTitle} />
            </div>
            <div className="pageArea">
                <ReactPaginate
                    previousLabel={"Previous"}
                    nextLabel={"Next"}
                    pageCount={numOfPages}
                    onPageChange={changePage}
                    containerClassName={"pageButtons"}
                    previousLinkClassName={"previousButton"}
                    nextLinkClassName={"nextButton"}
                    activeClassName={"activePage"}
                    disabledClassName={"disabled"}
                />
            </div>
        </>

    )

}

export default QueuedTickets;