# BountyHunter

java 2D game for Objected Oriented Programming final project for University of Bologna

# Project

BountyHunter.
Inizia il gioco , tu sei un cacciatore di taglie e ti trovi in una città (HUB) dove è possibile consultare la bacheca delle taglie(che funziona a step spiego poi), lo shop per migliorare il tuo equipaggiamento oppure giocare a dei minigiochi per guadagnare il vile danaro.
Le Taglie funzionano a Step => tu completi tot taglie guadagnando dei sordi , sti soldi li usi per copparti potenziamenti , e ogni tot taglie sblocchi il set di taglie successive più difficili (i nemici fanno pù danno ecc.).

Nell’hub ci sarà anche una zona Arcade cioè una zona in cui si potrà giocare a cose tipo le slot (ludopatia porco dio), a bountyhunter e a giochi semplici di questo tipo , questa zona permette al giocatore di fare una partita a questi giochi facendogli spendere dei soldi del gioco con la possibilità di vincere soldi e/o skin e/o armature/armi => ad esempio in bountyhunter dopo un tot di rimbalzi (50, 100 ) si sblocca un premio .

Le caccia alle taglie si svolge in una zona diversa dall’hub raggiungibile da una barchetta (loading zone) , questa zona sarà completamente generata randomicamente (se non riusciamo facciamo statiche e fanculo) dove ci sarà una stradina da fare per raggiungere il boss della taglia .

I Boss di ciascuna taglia saranno tutti diversi quindi ci saranno magari alcuni boss semplici (li prendi a spadate e bona li) e alcuni che avranno magari delle meccaniche personalizzate del tipo che ogni tot secondi il boss ha uno scudo che lo rende invulnerabile.

## Development

1. clone the repo
```bash
git clone https://github.com/progetto-oop/BountyHunter.git
```

2. depends on the system witch run the java applicaton

    - on MacOs/Linux run from the root of the project
    ```bash
    ./StartProject.sh
    ```
    - on Windows run from the root of the project
    ```bash
    StartProject.bat
    ```
    
3. if using vscode the configured launch for running or debugging the application is already configured

## Rules

development rules:

1. Don't place any file in the root folder , those won't be compiled/runned
2. Place your source files in the app/src/main/java folder
3. Place all the testes under app/src/test/java folder
4. Place all the resources on app/src/main/resources
5. Follow MVC pattern placing the file in the right folder based on what the file do
6. Do not place graphical code in the same class or file of a logical code

## Contributing

To contribute to BountyHunter, follow these steps:

1. Fork this repository
2. Create a new branch (`git checkout -b feature/[FEATURE_NAME]`)
3. Make changes and commit them (`git commit -am '[COMMIT_MESSAGE]'`)
4. Push to the branch (`git push origin feature/[FEATURE_NAME]`)
5. Create a new Pull Request on nightly branch

## License

The project is released under GPL v2.0 License

## Owner

-   [@FabioFattori](https://github.com/FabioFattori)
-   [@MattiaSenni](https://github.com/mtttia)
-   [@FrancescoTonelli](https://github.com/FrancescoTonelli)
-   [@AlessandroBuono](https://github.com/AlessandroCrazy)
