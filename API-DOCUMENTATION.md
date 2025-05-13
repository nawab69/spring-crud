# Book API Documentation

This application provides both REST and GraphQL APIs for managing books.

## REST API Endpoints

The REST API is available at `/api/books`:

### Get all books

```
GET /api/books
```

### Get a book by ID

```
GET /api/books/{id}
```

### Create a new book

```
POST /api/books
Content-Type: application/json

{
  "title": "Sample Book",
  "author": "John Doe",
  "isbn": "1234567890"
}
```

### Update a book

```
PUT /api/books/{id}
Content-Type: application/json

{
  "title": "Updated Book Title",
  "author": "John Doe",
  "isbn": "1234567890"
}
```

### Delete a book

```
DELETE /api/books/{id}
```

## GraphQL API

The GraphQL API is available at `/graphql`. You can also use the GraphiQL UI at `/graphiql` for testing queries interactively.

### Queries

#### Get all books

```graphql
query {
  allBooks {
    id
    title
    author
    isbn
  }
}
```

#### Get a book by ID

```graphql
query {
  bookById(id: "1") {
    id
    title
    author
    isbn
  }
}
```

### Mutations

#### Create a new book

```graphql
mutation {
  createBook(title: "New Book", author: "Jane Smith", isbn: "0987654321") {
    id
    title
    author
    isbn
  }
}
```

#### Update a book

```graphql
mutation {
  updateBook(id: "1", title: "Updated Title", author: "Updated Author") {
    id
    title
    author
    isbn
  }
}
```

#### Delete a book

```graphql
mutation {
  deleteBook(id: "1")
}
```

## Testing the APIs

### REST API

You can use tools like Postman or curl to test the REST endpoints.

### GraphQL API

You can use the built-in GraphiQL interface at http://localhost:8080/graphiql to test your GraphQL queries and mutations interactively.
