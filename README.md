# email dei partecipanti
- fabio.fattori3@studio.unibo.it
- mattia.senni@studio.unibo.it
- francesco.tonelli9@studio.unibo.it
- alessandro.buono4@studio.unibo.it

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


# idea del gruppo
il gruppo si impegna a realizare un gioco in grafica 2D che simula le avventure di un cacciatore di taglie.

Il gioco implementerà una parte di combattimento in un mondo simulato in mezzo alla foresta, dove il giocatore dovrà trovare il nascondiglio dei Boss e sconfiggerli per ottenere delle medaglie e dei dobloni.

Il boss sarà protetto da dei minion, che saranno presenti anche durante il viaggio del nostro eroe.

Sconfitti tutti i boss presenti, il gioco finisce.

# Funzionalità minimali ritenute obbligatorie:
- HUD ⇒ interfaccia utente che mostri la vita, l’arma equipaggiata e i dobloni del giocatore
- 3 categorie di armi (armi da taglio, distanza, contundenti a corto raggio)
- solo un arma per categoria (spada, arco, tirapugni)
- 1 boss con 3 tipologie di nemici (una per categoria di arma)
- ogni creatura sconfitta lascia cadere dei dobloni per il giocatore
- un fabbro che ripara le spade e vende le munizioni in cambio di dobloni (le armi contundenti non si rompono , le spade dopo n colpi si rompono)
- se muori il gioco finisce e riparti da zero
- dopo una certa quantità di tempo senza prendere danni, il protagonista recupera un tot di vita persa
- La mappa dovrà essere spostata in base al giocatore che starà sempre al centro della schermata

# Funzionalità opzionali:
- più armi per categoria
- mercante che vende le armi
- HUB ⇒ è una zona franca dove poter comprare armi dal mercante e dove si troverà anche il fabbro
- slot machine nell’HUB che permette al giocatore di scommettere i propri dobloni per tentare di acquisirne di più
- minigiochi nell’hub che permettono di acquisire dei dobloni al player se batte dei record.
- più boss e tipologie di minion
- oltre alle ricompense ottenute dalla sconfitta delle creature , ci sarà anche un sistema di taglie sui boss (sconfiggi un determinato boss ⇒ puoi riscattare la taglia che dona all’utente dobloni e/o armi)
- power up trovati casualmente nella mappa ⇒ alla raccolta incrementano delle statistiche del player per tot secondi

# Challenge principali:
- mantenere il modello MVC all’interno del progetto, mantenere alto il livello di codice e software versioning
- mantenere il gioco performante
- realizzare una IA per i nemici ed i boss
- realizzazione della mappa di gioco
- realizzare la collision detection in relazione alla mappa

# Suddivisione dei ruoli:
- Fabio Fattori ⇒ Render mappa di gioco , tutte le dinamiche del player (recupero vita ecc.)
- Francesco Tonelli ⇒ implentazione HUD , realizzazione e implementazione Sprite di gioco e musiche d’ambiente , fabbro
- Mattia Senni ⇒ dinamiche nemici e boss (IA , spawn casuale , ottimizzazione del render , loot nemici )
- Alessandro Buono ⇒ fisica e interazione con le armi, dinamiche di gameOver
