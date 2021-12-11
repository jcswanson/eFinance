# eFinance
Group project made with Spring Boot. eFinance is a web application used for loan application and lending account access.

#Instructions - Running the application
Setup:
- In order to first run the application you must have MySQL Workbench installed and either intellij or another IDE
- Create a new schema in your MySQL workbench and name it "eFinance" or something similar (you will need to link this name in the application.properties)
- Either use git clone "this repository" or download the zip of this application and open it in your favorite IDE
- Locate the application properties and change the URL, Username and Password to match your credentials (URL "/eFinance" is what you would change to match your schema name)
- run EFinanceApplication and in a browser type in localhost:8080
- Congrats! eFinance should now be running 

# User - Refactoring implementations
User:
- Future implementations will allow users to update and view their account details. 

Login:
- Allows users to login if they have a registered account in the database
- Only logged-in users can access the Account and Financing section of the web application. 

Register:
- Able to register an account without any problem
- Using password hashing to store passwords in MySQL database

Loan Application:
- Allows users to apply for an automobile loan
- Allows users to apply for a personal loan
- Allows users to apply for a business loan
- Users are able to register and view all their loan applications in the "My Loans"  tab

Loan Status:
- Users are able to view their loan status as either "SUBMITTED", "DENIED" or "APPROVED"
- Future implementations will allow users to view the reason they were denied the loan. 

Bank Account:
- Users are able to register a bank account in order to add it to their account to pay their loans
- Future implementations will have an update, edit, view and delete functionality (REST)

Logout: 
- Allows users to successfully logout of the web application
- Brings the user back to the home page

# Admin - Refactoring implementations

Admin:
- There is an in-memory admin accounts stored for access.
- Username: ATZ 
- Password: atz

ATZ Clients:
- Admins have access to view all users that are registered to eFinance
- Future implementations will allow for REST in order to delete, update and view all account details

ATZ Loans:
- Admins have access to all submitted loan applications
- Admins have access to approve or deny a loan based on whether the loan status is submitted or not
- Approved or denied loans change status and the buttons associated as well
- Future implementations will allow admins to submit description as to why a loan was denied for the user to view






