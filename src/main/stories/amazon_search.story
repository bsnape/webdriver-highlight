Search Amazon.co.uk

Narrative: 

In order to show the cool highlighting method
As a user
I want to search for something

Scenario: Searching Amazon.co.uk

Given I am on amazon.co.uk
When I search for product: <product>
Then I can see a product image and rating

Examples:
|product|
|Agile Testing|
|Pragmatic Programmer|
|Specification by Example|