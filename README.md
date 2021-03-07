#DOCUMENTATION
https://jimm063.bit.ai/docs/view/q66Pqvb4fNw3Xl3c

# Back-end Developer Test 2

You are to write a new API that will allow users to share feedback on their grocery orders and allow visibility to a live operations team.

Users can rate their orders from 1 to 5 and leave a comment. Order ID is provided in the url path and the User ID is in the header named `UserId`.

**User can only leave one feedback per order.**

### Functionality

1 - Write an HTTP endpoint for users to be able to create/read/edit/delete a feedback for an order.

2 - Write an HTTP endpoint to get the **last** 20 feedbacks left by users and allow filtering by rating.

- The API should follow typical RESTful API design pattern.
- The data should be saved in the DB.
- Provide proper API documentation.
- Proper error handling should be used.

## What We Care About

Use any libraries that you would normally use if this were a real production App. Please note: we're interested in your code & the way you solve the problem, not how well you can use a particular library or feature.

_We're interested in your method and how you approach the problem just as much as we're interested in the end result._

Here's what you should strive for:

- Good use of the backend stack selected
- API design best practices.
- Solid testing approach.
- Extensible code.

### Basic Requirements

  - Use Springboot (Java or Kotlin) or NodeJs (Express, Loopback or Hapi framework)
  - Use any persistence store, explain your selection.
  - Write concise and clear commit messages.
  - Write clear **documentation** on how it has been designed and how to run the code.

### Bonus

  - Provide proper unit tests.
  - Add an endpoint to allow users share feedback about the items contained in its orders
  - Providing an online demo is welcomed, but not required.

## Good luck!

We look forward to seeing what you can do. Remember, although it is a test, there are no specific right or wrong answers that we are looking for - just do the job as best you can.
