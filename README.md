A simple command-line Task Management application written in Java, demonstrating task creation, deletion, status updates.

## Features

- Add tasks with title and description  
- View tasks with status (`PENDING`, `IN_PROGRESS`, `DONE`)  
- Update task status  
- Delete tasks  

## Project Structure

Task-Manager/
│
├─ src/
│ ├─ app/ # Main application entry point
│ ├─ model/ # Task and Status classes
│ └─ service/ # TaskManager service for operations
│
├─ Dockerfile # Docker configuration
└─ README.md


## How to Run
```bash
git clone https://github.com/amhrahat/Task-Manager.git
cd Task-Manager
docker build -t to_do_app .
docker run -it --rm to_do_app


