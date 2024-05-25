# Watch It

Welcome to Watch It, an entertainment application that offers a vast collection of movies to users, inspired by the popular platform.

### Description
Watch It is designed with 6 main entities to efficiently manage and track movie-related data:
1. User: Users have unique IDs, usernames, passwords, and personal information. They can subscribe to different plans, mark movies to watch later, and maintain a watch record.
2. Subscription: Subscriptions are categorized into Basic, Standard, and Premium plans, each with its price and start date.
3. Movie: Movies are characterized by various attributes such as ID, title, release date, duration, cast, genres, director, language, IMDb score, country, budget, revenue, and poster image.
4. Cast: Actors in the movies are represented by their first name, last name, age, gender, list of movies, and nationality.
5. Director: Directors are depicted with their first name, last name, age, gender, list of movies, and nationality.
6. User Watch Record: This entity tracks users' movie-watching activities, including the date of watching and user ratings.

### Constraints
Subscriptions are valid for 30 days. Users under the Basic, Standard, or Premium plan have specific limits on the number of movies they can watch per month. After 30 days, users need to renew their subscription to continue watching movies.

### Functionalities
1. CRUD Operations: Users can add, update, and delete entities such as movies, subscriptions, and user watch records.
2. View Watchlist: Users can display the list of movies marked for later viewing.
3. View Watch History: Users can view all movies they have already watched.
4. Movie Rating Update: Movie ratings are updated based on user watch records.
5. Top-Rated Movies: Users can view top-rated movies based on user ratings.
6. Subscription Analysis: Admins can see the most subscribed plan among Basic, Standard, and Premium.
7. Revenue Analysis: Admins can analyze revenue trends by summing up plan prices subscribed in a month.
8. View Cast and Directors: Users can explore information about cast members and directors.
9. Search Functionality: Users can search for movies, directors, and actors by name.
10. Genre Search: Users can search and display movies by genre.
11. Top Watched Movies: Users can view the top-watched movies.
12. Recent Movies: Users can explore recently released movies.
