# TRMS-v4

## Project Description

TRMS, or Tuition Reimbursement Management System is a full-stack web application that allows employees to submit requests for reimbursements for courses, events, and certifications. These requests can then be approved or rejected by the employee's direct supervisor, department head, and a benefits coordinator while the employee is able to track the status of their requests.

## Technologies Used

- PostgreSQL
- Java
- JavaScript
- HTML
- CSS
- Hibernate
- JDBC
- JUnit4
- Maven
- Postman

## Features

List of ready features

- User can log in if they have an existing account
  - program will verify that they are truly an employee
 
- In the portal, User will have various buttons to choose
  - "Submit New Form"
    - user will be able to submit a new reimbursement request form
    
  - "View Existing Forms"
    - user can view the status of all their previously submitted forms
    
  - "View Forms Pending Approval"
    - user will be able to approve / deny forms pending their approval
    - will only show up if the user is a supervisor or BenCo employee of some sort

To-do list:
- Populate the details of a specific form when "View Details" button is clicked in approve / deny phase
- Implement the user's ability to submit their grade from the event

## Getting Started

To clone and run this application, you'll need [Git](https://git-scm.com/) and [Node.js](https://nodejs.org/en/download/) (which comes with npm) installed on your computer. From your command line:

```
# Clone this repository
$ git clone https://github.com/melimartinez/TRMS-v4.git

# Go into the repository
$ cd TRMS-v4

# Install dependencies
$ npm install

# Run the app
$ npm start
```

Note: If you're using Linux Bash for Windows, [see this guide](https://www.howtogeek.com/261575/how-to-run-graphical-linux-desktop-applications-from-windows-10s-bash-shell/) or use `node` from the command prompt.

## Usage


## License
This project does not use a license.
