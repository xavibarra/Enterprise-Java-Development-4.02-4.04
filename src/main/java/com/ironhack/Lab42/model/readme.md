# QUESTIONS

Did you use the same type of route to update patient information and to update an employee department?
Why did you choose the strategy that you chose?
What are the pros and cons of the strategies you chose for creating these routes?
What are the tradeoffs between PUT and PATCH?

- No, because to update patients we use PUT and to update the employee department we use PATCH, this is so because we use the "patch" to update the specific data of an entity, as is the case of the departments and, instead , in the case of "put" it serves us to update the entire entity, it is useful to take into account what we want to do since, although with "put" we could modify the employee department we would use too much memory for something that we can do in a much more efficient way with the "patch" method.

