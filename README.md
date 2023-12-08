# Home life simulation

## Diagrams:
- [UML diagram](diagram/uml_final.pdf)
- [Initial UML diagram](diagram/uml_v1.pdf)
- [Initial UC diagram](diagram/uc_v1.pdf)

## Design patterns used (10):
- **Builder**. Used to create a house, floors and rooms. In package: `/smarthome/home`, `/smarthome/room`.
- **Singleton**. Used to create objects that will have only one instance. The two types of singleton used are LAZY and EAGER. In package: `/smarthome`, `/appliance/factory`.
- **State**. Used to create new classes for all possible appliance states. In package: `/appliance/state`.
- **Lazy Loading**. Used to generate appliance manual only in case the appliance breaks. In class: `/appliance/HomeAppliance`.
- **Factory Method**. Used in the creation of appliances. In package: `/appliance/factory`.
- **Composite**. Used to update the house and its components (floors, rooms, executors, appliances). In package: `/component`.
- **Visitor**. Places the new behavior in a separate Visitor class instead of integrating it into existing classes. Used to generate Home Configuration Report and Consumption Report. In package: `/report`.
- **Observer**. Notifies if an appliance breaks or sensors are activated. In package: `/appliance/observer`.
- **Template Method**. Defines the activity skeleton, subclasses override the `solve()` step. In package: `/entity/activity`.
- **Facade**. Provides a simple interface for running simulation. In class: `SimulationFacade`.

## Requirements:

### Functional:
- [x] The entities we are working with are house, window (+ blinds), floor in the house, sensor, device (=appliance), person, car, bike, pet of other than farm type, plus any other entities.
- [x] Individual devices in a house have an API to control them. Devices have a state that can be changed using the API to control it. Actions from the API are applicable according to the state of the device. Selected devices can also have content - a fridge has food, a CD player has CDs.
- [x] Appliances have their consumption in active state, idle state, off state.
- [x] Individual devices have an API to collect data about that device. We collect data about devices like electricity, gas, water consumption and functionality (decreases linearly with time).
- [x] Individual persons and animals may perform activities that have an effect on the device or another person. E.g. Gas_ket_1[open_gas] + Father.closeGas() -> Gas_ket_1[closed_gas].
- [x] Individual devices and persons are in the same room at any time (unless they are playing sports) and randomly generate events (an event can be important information or an alert).
- The events are picked up and handled by the appropriate person(s) or device(s). For example:
    - wind sensor (wind) => pulling the outside blinds 
    - circuit breaker (power failure) => switching off all non-essential appliances (only the necessary ones remain in operation)
    - humidity sensor (burst water pipe) => mom -> call the fire brigade, dad -> shut off the water; daughter -> catch the hamster 
    - Baby needs changing => dad hides, mom -> changing 
    - Device stopped working => ...
    - The fridge is out of food => ...
- [x] Generating reports:
  - HouseConfigurationReport: all configuration data of the house maintaining the hierarchy - house -> floor -> room -> window -> blinds etc. Plus what are the occupants of the house. 
  - EventReport: event report, where we group events by type, event source and event target (what entity handled the event)
  - ActivityAndUsageReport: report of activities of each person and animal, how many times which person used which device. 
  - ConsumptionReport: how much electricity, gas, water each appliance consumed. Including a financial calculation.
- [x] When a device breaks, the home occupant must examine the documentation for the device - find the warranty card, review the repair manual, and take corrective action (e.g., do-it-yourself repair, purchase a new one, etc.). Manuals take up a lot of space and take a long time to find. Hint: Model as simple actions ...documentation is accessible as a variable directly in the device, however it is only touched when needed.
- [x] The family is active and spends leisure time in roughly the ratio (50% using appliances in the house and 50% sports when using sports equipment bike or skis). When there is no spare appliance or sports equipment, the person waits.

### Non-functional:
- [x] Neither authentication nor authorization is required.
- [x] The application can only run in one JVM.
- [x] Write the application in such a way that methods and variables that should not be available to other classes are well hidden. The generated javadoc should have as few public methods and variables as possible.
- [x] Reports are generated in a text file.
- [x] The house, device and occupant configurations can be loaded directly from the class or an external file.

### Outputs:
- [x] Design in the form of use case diagrams, class diagrams and a brief description of how you want to implement the task.
- [x] Public API - Javadoc generated for the functions the user uses to interact with your software.
- [x] Two different house configurations and reports generated for them for different periods. The minimum configuration of at least one house is: 6 people, 3 animals, 8 types of appliances, 20 appliances, 6 rooms, skis, bikes etc. 

## Start simulation

1. Starting is done in the `Main` class using the IDE.
2. Type `T` to use a large configuration (3 floors, 9 rooms, 8 person, 4 pets) or `F` for a small configuration (2 floors, 7 rooms, 6 person, 2 pets).
3. Enter the number of days for the simulation. The number must be greater than 29 and less than 366.
4. If the simulation is being run a second time, enter `T` to remove the previous reports.
5. All reports can be found in the `/report` folder. 
