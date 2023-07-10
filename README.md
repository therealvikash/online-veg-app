# online-veg-app
1. This is backend development for an online vegetable app.
2. online-veg-app has the logic of signing in as **Customer** OR **Vendor**.
3. Vendor can list the items in the app for customer to browse and remove if the item is out of stock.
4. Customer can browse the vegetables available in the stock and add to their cart as per their desire.
5. It has logic to go to billing section after the customer check out and has the basic calculation of items about.
6. Customer has the liberty to give feedback for the items they have bought.
7. The operations are mapped using mapping such as oneToOne, oneToMany, manyToMany, etc.
8. The exception handling is done for all the methods and calls.
9. Apart from this, the project has jenkins pipeline stages, to do gradle build, test, check code coverage
   using sonarqube and sonar quality gate as well. Once the condition of quality gate is satisfied, the
   artifact of the projects get deployed to Nexus. Also the docker config file is present, which basicall
   pushes the image to docker hub.
