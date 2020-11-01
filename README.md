# TODO List Implementation
Objectives:
  - Getting familiar with Java and especially SpringBoot
  - Implement a layered architecture
  - Get familiar building a project with Gradle
  - Focus on some DDD concepts where applicable

## Bounded Contexts of a TODO List
  - TodoList - The main domain in question
  - Users - A necessary subdomain to do anything useful.  Will ignore this to start

## Aggregates:
  - TodoList
  - Item - Open question.  On the one hand, it feels like TodoList should be THE aggregate.  But in our bounded context, so many actions are happening directly with an Item.  
  
## Ubiquitous Language
  - *TodoList* - The main entity in our context.  One list can consiste of multiple items.
  - *Item* - The main subcomponent of the TodoList that we wind up interacting with.  Each item can be created and then marked complete.
  
## Testing Policies
Full unit testing should be possible for:
- Anything in the Domain/model that has logic (any entity that has actual methods)
- Most functionality at the Service/application layer

Layers that don't get unit tests would be:
- Infrastructure layer, such as Repository
- UI layer (TODO - spring may provide magic thanks to the HttpConverter black magic)

## Notes on Attempting to Implement Layers:
- UI for a Http/Rest-ish service seems to automatically meld with the Domain.  We think of CRUD operations to 
interact with our domain objects, so we have users directly POSTing an object they will create.  
I try to counteract this by clearly differentiating "User-Input" version of the 
entities, versus the "real" entities.  This provides us with a clear segregation of what the user inputs, versus the 
real thing.  It does result in a ton of boilerplate code though. 
- Similarly, I don't think we should simply directly return a serialized representation of our domain objects to our
clients.  While that IS the main thing to return, the actual return data should also contain extra information such as 
potential errors.  So again, I experiment with a similar but slightly different entity dedicated to being a 
ResponseEntity.
- Repository vs Dao is ambiguous to me.  The one clear point that makes sense is that a Repository still speaks the 
language of our domain model.  And a DAO can be a truly infrastructure-specific class.  But what I don't understand is
what our repository actually would do if we tried to use both.  It would become a largely useless translator that simply
defines methods like list.create and translates it to a dao call for list.insert, which doesn't seem useful.  
