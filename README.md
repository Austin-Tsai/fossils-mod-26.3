# Fossils

Fossils generated undergroud at extremely rare chance in a dirty status.
Dirty bone blocks can be cleaned with brush, with a chance to uncover rare bone items.
Dirty bone blocks can be cleaned with water in faster rate than brush, but no item drops.

Fabric mod for Minecraft 26.3

Built at **MadHacks** in 24 horus by Austin-Tsai, and AlexandraDPark

## Demo video / Screenshots

https://github.com/user-attachments/assets/640df9bb-c400-4233-9707-7999379f9be5

https://github.com/user-attachments/assets/a228ecbd-368c-465a-9d08-52f9302b6df2

<img width="1510" height="837" alt="structures" src="https://github.com/user-attachments/assets/df0ff0cc-c578-43b9-a95d-ce895cfcb155" />


## Features

- **Buried fossils** Large bone structures generated underground.
- **Dirty bone blocks**: Brush them with a brush to slowly clean them through 4 stages.

## Item
- **Sharp bone**: Rare weapon found while brushing. 5% drop rate, 5 damage, 2.0 attack speed
- **Bone fragment**:
- **Bone arrow**: 

## How we built it
- **Brushing.** Our block extends vanilla's `BrushableBlock`, the same code behind suspicious sand. We removed the falling behavior and added our own loot table.
- **Textures.** 16x16 pixel art made from vanilla's bone block, with 4 stages of dirt coverage.
- **Fossil generation.** We built the fossils in creative mode, saved them with Structure Blocks, and used vanilla's `minecraft:fossil` feature to bury them underground.
- **Items.** Registered with Fabric. The Sharp Bone uses attribute modifiers for custom damage and attack speed. 
- **Tools:** Java 25, Fabric, IntelliJ IDEA, Gradle, Git and GitHub, Piskel.
