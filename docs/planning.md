# Environment Modeling

### Goals
The agent's goals consist of conditions the agent wants to satisfy. \
**Example Goals:**
- Stay alive
- Keep fire burning

### Plan
A plan is sequenceo of actions that satisfy satisfy a goal.

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

### World State
\# of trees in forest \
\# of fish in lake

### Planner
Assign weights to actions


### Agent
