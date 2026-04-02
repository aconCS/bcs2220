# Environment Modeling

### Goals
The agent's goals consist of conditions the agent wants to satisfy. \
Example Goals:
- Stay alive
- Keep fire burning

### Plan
A plan is sequenceo of actions that satisfy a goal.

**Example Plan:**

1. Get axe (2) -> Cut Wood (3) -> Put wood in fire (2)
2. Pickup wood (2) -> Put wood in fire (2) # there is cut wood available 
3. Put wood in fire (2) # you already have wood

### Actions
Cut wood
- Effects -> Gain wood
- Prerequisites -> Have axe 

Pickup axe 
- Effects -> Equip axe
- Prerequisites -> No Equipped axe

Put wood in fire
- Effects -> Fire burn timer += 10
- Prerequisites -> Have wood

Eat
- Effects -> Hunger += 10
- Prerequisites -> Have fish

Get Fish
- Effects -> Gain fish
- Prerequisites -> No fish

### Planner
The planner will look at an action's effects and preconditions in order to create a queue of actions that can satisfy a goal.

The planner is given a goal, along with the world's state and a list of valid actions in order to formulate a plan.

### World State
- \# of trees in forest.
- \# of fish in lake.
- is axe equiped?
 
### Necessary Components

- Action
- Planner
- Agent
- FSM
- FSMState
- GOAP interface (planner uses this to access world data)