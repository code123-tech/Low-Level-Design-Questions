## Template Method Pattern (Chapter 8)

This folder contains the **code implementation** for Chapter 8 (Template Method Pattern) from *Head First Design Patterns (2nd Edition)*.

### Folder structure

- `beverages/` - Starbuzz tea/coffee template method
- `beverages/hooks/` - hook version (optional condiments)
- `wild/ducks/` - Arrays.sort + Comparable example
- `wild/swing/` - JFrame paint hook example

### Files included

- **Starbuzz beverage example** (`beverages/`)
  - `CaffeineBeverage.java` (template method)
  - `Tea.java`, `Coffee.java` (concrete subclasses)
  - `BeverageTestDrive.java` (runs both normal + hook flows)

- **Hook version** (`beverages/hooks/`)
  - `CaffeineBeverageWithHook.java` (template method + hook)
  - `TeaWithHook.java`, `CoffeeWithHook.java` (hook overrides)

- **Template methods in the wild**
  - `wild/ducks/Duck.java`, `wild/ducks/DuckSortTestDrive.java` (Arrays.sort + Comparable)
  - `wild/swing/MyFrame.java` (JFrame paint hook)

### How to run (example)

From this folder (or with your IDE), run:

- `TemplateMethod.beverages.BeverageTestDrive` (template + hook demo)
- `TemplateMethod.wild.ducks.DuckSortTestDrive` (Comparable sorting demo)
- `TemplateMethod.wild.swing.MyFrame` (Swing hook demo)

