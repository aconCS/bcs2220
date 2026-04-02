# Terminology

### Pure Functions
Pure functions guarantee same output value for the same given input with no side effects.

### Total Functions
Subset of pure functions that also guarantee a valid return value for every possible input value inside the declared data type's range.

## Self Notes

### Not all functions need to be total
Keep private functions pure, and public functions total.

### Not all functions need to be pure
In functional programming your goal is to keep all functions in the core to be pure, any functions in the shell can be impure. 

- Shell (Impure): Reading data, getting current time, or fetching something from an API with side effects can be impure.
- Core (Pure): Heavy processing, like calculations or decisions are made in a pure core.
- Shell (Impure): Output, like writing or displaying something can be impure.



