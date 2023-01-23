# Estately
![Screenshot 2023-01-23 at 03 51 34](https://user-images.githubusercontent.com/119360734/213956339-42a0329e-522b-4da3-adea-6e844e78a8b7.png)



The only real estate api you will ever need

***APP Functionality and Business Case***

Estately is a real estate api that provides data about properties sold in different areas (zones). 
It attempts to bridge the gap between actual sellers and interested clients, relying on real estate agents as little as possible. 
If, however the assistance of a real estate agent is required the api will provide you with the information needed to do so.

***Main Features***
1. Listings of all available properties present in certain areas.
2. Ability to choose between real-life sellers and agents.
3. Obtaining real-time data about the state of the property, as well as the authenticity of the listing.
4. Oferring the contact info and time to be contacted so as to better manage your time.

***Entities***
1. Listing: The available property listed on sale. It contains a name and a set price.
2. ListingDetails: Precious details about the property on sale, as well as its actual state and type of neighbourhood.
3. Seller: Information about the seller and all the properties currently in her/his listings.
4. Zone: It specifies the zone in which the available listings reside.
5. Contact: Handles all responsible information retrieval for contact info from both the seller and the potential client.
6. Agent: Relevant information about an available agent such as name and other contact information.
