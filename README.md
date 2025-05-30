# JobProcessor

This is an application made for queueing jobs. Upon receiving a job, it is inserted into a PostgreSQL database and sent to RabbitMQ. Then the jobs are automatically consumed by the application.

## Functionalities

Current functionalities include:
- `POST /jobs` takes job type and payload as parameters and adds a new job to the queue.
- Jobs are consumed upon arriving in the queue (there is currently no actual business logic behind that processing, but it can be added by changing one method's body).