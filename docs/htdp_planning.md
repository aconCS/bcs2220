# HtDP Planning Java

## Data Definitions

### Actions
`/* The Action record is an abstract structure
representing an Action that an agent can take and constists of a list of prerequisities, list of effects, an identifier, and a weight. 
*/`

`/* public sealed interface Action<X> permits Action1, Action2 */`

`public record Action1 (pre_req, effects, id, weight)`


`public record Action2 (pre_req, effects, id, weight)`

### Goals
`/* The Goal record is an abstract structure representing a condition that an agent needs to satisfy by performing a list of valid pre-requisite actions, whose effects changes the world state. 
*/`

`/* public sealed interface Goal<X> permits Goal1<X>, Goal2<X> */`

public record Goal (String id, list pre_req)

public record WorldState (hunger, hasAxe, trees, bears )

Worldstate -> game_tick -> NewWorldState\

gametick 


queue = {chop1, eat}

queue -> gametick ->  newWorldState 

A* recursion, no while loops functional