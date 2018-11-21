# Introduction

This is a simple clojure REST example that denmonstrates how a REST api can be built using clojure, ring and composure.

## Routes

# Get all cars
GET http://localhost:3000/example/api/car

# Get a particular car
GET http://localhost:3000/example/api/car/:id

# Save a car given in the body
POST http://localhost:3000/example/api/car