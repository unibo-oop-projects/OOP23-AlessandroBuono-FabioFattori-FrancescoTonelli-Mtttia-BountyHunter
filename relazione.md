\
\
\
\
\
\
\
\
\
\
&#8203;
# <center>BuontyHunter</center>
### <center>Da un idea di Fabio Fattori , Mattia Senni , Francesco Tonelli e Alessandro Buono</center>
\
\
\
\
\
\
\
\
\
\
&#8203;
# Indice

- [Analisi ](#analisi)
    - [1. Requisiti](#1-requisiti)
      - [1.1 Requisiti Funzionali](#11-requisiti-funzionali)
      - [1.2 Requisiti Non Funzionali](#12-requisiti-non-funzionali)
    - [2. Analisi e Modello del Dominio ](#2-analisi-e-modello-del-dominio)
- [Design ](#design)
    - [1. Architettura ](#1-architettura)
    - [2. Design dettagliato ](#2-design-dettagliato)
        - [Fabio Fattori](#21-fabio-fattori)
        - [Mattia Senni](#22-mattia-senni)
        - [Francesco Tonelli](#23-francesco-tonelli)
        - [Alessandro Buono](#24-alessandro-buono)
        - [Codice riadattato per la realizzazzione](#25-codice-riadattato-per-la-realizzazzione)
- [Sviluppo ](#sviluppo)
    - [1. Testing Automatizzato ](#1-testing-automatizzato)
    - [2. Note di sviluppo ](#2-note-di-sviluppo)
        - [Fabio Fattori](#21-fabio-fattori-sviluppo)
        - [Mattia Senni](#22-mattia-senni-sviluppo)
        - [Francesco Tonelli](#23-francesco-tonelli-sviluppo)
        - [Alessandro Buono](#24-alessandro-buono-sviluppo)
- [Commenti Finali ](#commenti-finali)
    - [1. Autovalutazione e Lavori Futuri ](#1-autovalutazione-e-lavori-futuri)
        - [Fabio Fattori](#21-fabio-fattori-autovalutazione)
        - [Mattia Senni](#22-mattia-senni-autovalutazione)
        - [Francesco Tonelli](#23-francesco-tonelli-autovalutazione)
        - [Alessandro Buono](#24-alessandro-buono-autovalutazione)
    - [2. Difficoltà Incontrate e Commenti per i Docenti ](#2-difficoltà-incontrate-e-commenti-per-i-docenti)
- [Guida Utente ](#guida-utente)

# Analisi

Il software prevede di realizzare una simulazione delle avventure di un cacciatore di taglie, il giocatore prenderà i panni del protagonista, per simulazione si intende che il software dovrà consentire al giocatore di intraprendere missioni , guadagnare ricompense e migliorare il proprio equipaggiamento.

### 1. Requisiti
#### 1.1 Requisiti Funzionali
- Il software dovrà consentire la corretta visualizzazione di un mondo simulato , del giocatore , dei nemici e delle missioni.
- Inoltre il giocatore come i nemici si potranno muovere e attaccare all'interno del mondo simulato , il giocatore si muoverà tramite l'input da parte dell'utente mentre i nemici si muoveranno in modo autonomo.
- Il giocatore potrà attaccare i nemici e i nemici potranno attaccare il giocatore.
- Il software dovrà consentire la corretta visualizzazione di un HUD che mostri la vita, l'arma equipaggiata e i dobloni del giocatore; ed inoltre dovrà implementare un sistema di missioni e ricompense all'adempimento delle stesse.
- Il software dovrà anche fornire un interfaccia utente per la selezione dell'arma e per l'acquisto di nuove armi.

#### 1.2 Requisiti Non Funzionali
- Il software dovrà essere performante , in quanto dovrà essere in grado di gestire un numero elevato di entità all'interno del mondo simulato.
- Il software dovrà essere facilmente estendibile , in quanto dovrà essere possibile aggiungere nuove armi , nuovi nemici e nuove missioni senza dover modificare il codice alla base del gioco.

### 2. Analisi e Modello del Dominio

Il gioco sarà gestito secondo il modello ECB (Entity-Component-System) , il nostro controller dovrà permettere (uno alla volta) all'input di essere processato,alla fisica delle singole entità di essere aggiornata e alla grafica di essere disegnata. Tale Controller prenderà il nome di GameEngine e sarà il gestore/mediatore tra tutte le entità del gioco.
Ogni entità presente nel gioco prenderà il nome di GameObject e sarà composta da un componente che gestirà la fisica , un componente che gestirà la grafica,ed un componente che gestirà l'input.
Pensiamo di trovare particolarmente difficoltosa la gestione della fisica tra i singoli GameObjects e la gestione della grafica , in quanto dovrà essere possibile disegnare ogni singolo GameObject e dovrà essere possibile gestire le collisioni tra loro.

![no UML found](./relazioniImgs/analisi%20del%20dominio.png "1 Diagramma UML formato durante l'analisi del dominio")

Figura 1: Diagramma UML formato durante l'analisi del dominio, il diagramma mostra le relazioni tra le entità principali del gioco.

# Design 
### 1. Architettura 

L'architettura di Buontyhunter segue il pattern EBC (Entity-Component-System) come può essere visto anche nella figura 2.1:
- Il System è il GameEngine che è il gestore di tutta l'applicazione ,egli infatti permette a tutti i Componenti dei GameObject di aggiornarsi, in particolare dentro al GameEngine è presente il metodo StartGame che fa partire il gameLoop , questo ciclo richiama il metodo redraw(),updatePhysics() e processInput(); ognuno di questi metodi si occupa di chiamare i metodi corrispondenti di ogni GameObject presente .
- Le Entity sono appunti tutte le entità del gioco (GameObjects) , da un GameState che appunto serve per avere sempre una panoramica sullo stato del gioco , quindi se il player è morto oppure è vivo e in quale mondo/World il player si trova , e da un World appunto che contiene tutte le entità del gioco che appartengono al mondo corrente,compreso il player, questo mondo può essere cambiato per dal GameState per simulare un teletrasporto oppure un cambio di zona.
- I Component sono le parti che compongono le Entity , in particolare ogni GameObject ha un GraphicsComponent che si occupa di disegnare il GameObject , un PhysicsComponent che si occupa di gestire la fisica del GameObject , e un InputComponent che si occupa di gestire l'input del GameObject.

### toDo MODIFICARE 
![no UML found](./relazioniImgs/Architettura%201.png "2.1 Diagramma UML che descrive l'architettura del gioco concentrandosi sugli elementi principali che gestiscono i GameObjects")

&#8203;
2.1 Diagramma UML che descrive l'architettura del gioco concentrandosi sugli elementi principali che gestiscono i GameObjects


### 2. Design dettagliato 

**Problema** : Come fare a create ogni singolo GameObject che può essere prensente in gioco 

**Soluzione** : Abbiamo deciso di creare una classe chiamata GameFactory (che utilizza il pattern SingleTon) che si occupi di creare ogni singola entità del gioco , questa idea ci consente di avere un unico punto di creazione per ogni singolo GameObject e di poter facilmente aggiungere nuove entità al gioco senza dover modificare il codice alla base del gioco; questa idea ci è venuta vedendo altri programmi di creazione di videogiochi , es. Unity, che permettono appunto di creare qualsiasi entità si vuole tramite un unico punto di creazione.
Il Diagramma UML riportato sotto raffigura un esempio di utilizzo della classe GameFactory , in particolare si può intedere come la classe ChangeWorldEvent si occupi di creare un nuovo mondo chiamando tutti i metodi di cui ha bisogno di GameFactory.
Questo è solo un esempio di utilizzo di GameFactory , in realtà GameFactory può essere utilizzata in qualsiasi parte del progetto per creare qualsiasi entità del gioco.
Nella view (SwingScene) ho fatto in modo di far visualizzare/disegnare , all'apertura del QuestPannel , le missioni disponibili e solo quelle.

![no UML found](./relazioniImgs/GameFactoryDiagram.png "2.2 Diagramma UML che descrive l'utilizzo di GameFactory , raffigurando quindi solo i metodi interessati da ChangeWorldEvent, ma GameFactory vanta molti altri metodi, oltre a quelli mostrati")

&#8203;
2.2 Diagramma UML che descrive l'utilizzo di GameFactory , raffigurando quindi solo i metodi interessati da ChangeWorldEvent, ma GameFactory vanta molti altri metodi, oltre a quelli mostrati

#### 2.1 Fabio Fattori

**Problema** : Come fare a cambiare il mondo in cui si trova il player , per passare da Hub a OpenWorld e viceversa.

**Soluzione** : Ho deciso di creare un Teleporter che estende GameObject , ed in più ha una destinazione , grazie a questo GameObject è possibile cambiare il mondo in cui si trova il player , in particolare quando il player entra in collisione con il Teleporter , il TeleporterPhysicsComponent genera un Evento , più precisamente un ChangeWorldEvent , che tramite il metodo di World notifyWorldEvent(WorldEvent) che chiama il notifyWorldEvent(WorldEvent) di GameEngine viene aggiunto alla coda di eventi, che ogni game loop viene processata e poi pulita. 
In questo caso quindi il GameEngine deve solo chiamare il setWorld(World) di GameState per cambiare il mondo in cui si trova il player.

![no UML found](./relazioniImgs/TP%20diagram.png "2.3 Diagramma UML che descrive il processo di cambio del mondo in cui si trova il player tramite la generazione di un ChangeWorldEvent da parte di un Teleporter")

**Pattern Usato** : ChangeWorldEvent è un esempio di Observer Pattern , in quanto il GameEngine è l'Observer e il World è l'Observable , in particolare il World notifica il GameEngine di un cambiamento di stato tramite il metodo notifyWorldEvent(WorldEvent) , il GameEngine è in ascolto di questo evento e lo processa quando lo riceve.
Inoltre in Swing Scene è presente uno stato , rappresentato da un booleano chiamato isHub , quindi viene utilizzato il pattern State per cambiare lo stato della scena in base a isHub ; stato presente anche in ChangeWorldEvent , dove lo stato è rappresentato dalla destinazione del Teleporter.

&#8203;
2.3 Diagramma UML che descrive il processo di cambio del mondo in cui si trova il player tramite la generazione di un ChangeWorldEvent da parte di un Teleporter.

**Problema** : voglio rendere possibile che il player possa vedere tutta la mappa dell'openworld , grazie ad una minimappa , e che possa vedere le missioni che ha accettato.

**Soluzione** : Ho deciso di creare una classe HidableObject che permette al giocatore di premere un tasto prestabilito e far apparire/scomparire qualcosa sullo schermo.
La minimappa ed il registro delle missioni sono quindi un HidableObject , un HidableObject estende GameObject quindi ha bisogno di un GraphicsComponent che si occupi di disegnare la minimappa e il registro delle missioni , un InputComponent che se il tasto premuto è quello corretto apre e chiude l'HidableObject , e poi un PhysicsComponent che non deve fare nulla perchè questi oggetti non hanno fisica quindi gli assegno NullPhysicsComponent.
Nella View (SwingScene) è presente una classe innestata chiamata ScenePanel che implementa KeyListener e si occupa di settare a true oppure a falso il corrispondente campo booleano di un InputController presente in SwingScene , questo InputController è inizializzato ed usato nel GameEngine per processare l'input.
In questo modo l'HidableObject può essere reso visibile o invisibile a seconda del tasto premuto, a seconda quindi se il valore booleano contenuto in InputController è vero oppure falso.

![no UML found](./relazioniImgs/minimap%20e%20Quest%20Journal%20Diagram.png "2.4 Diagramma UML che descrive come è stato implementato l'HidableObject")

**Pattern Usato** : NullPhysicsComponent è un PhysicsComponent che non fa nulla , è il pattern comportamentale NullObject che permette di evitare di dover fare controlli su null.

**Problema** : come fare ad implementare il sistema delle missioni , in particolare come fare a far si che il player possa accettare una missione nell'hub e poi completarla nell'openworld.

**Soluzione** : Ho deciso di creare una classe chiamata PlayerEntity che estende FighterEntity , in questo modo posso aggiungere ad una FigherEntity una lista di Quest , in particolare ogni Quest ha un metodo start() e end() che vengono chiamati quando il player accetta una missione e quando la missione viene completata.
Le missioni vengono create dalla GameFactory e vengono rese disponibili da un QuestPannel che è un HidableObject che si occupa di disegnare le missioni disponibili e di far si che il player possa accettarle.
Fatto ciò dovevo trovare un modo per rendere visualizzabile l'HidableObject e quindi ho deciso di creare una nuova classe chiamata InterractableArea che estende GameObject e che ha un HidableObject come attributo , in questo modo posso rendere visualizzabile l'HidableObject quando il player entra in collisione con l'InteractableArea e preme un il tasto E.
Ho deciso di fare InteractableArea il più generale possibile per poterla utilizzare in futuro per rendere visualizzabili altre schermate come la schermata del fabbro creata da Tonelli Francesco.

![no UML found](./relazioniImgs/QuestSystemDiagram.png "2.4 Diagramma UML che descrive come è stato implementato il sistema delle missioni")

#### 2.2 Mattia Senni


#### 2.3 Francesco Tonelli


#### 2.4 Alessandro Buono


# Sviluppo

### 1. Testing Automatizzato 

I test sono implementati nel file AppTest.java (link di AppTestAggiornato) ed essi verificano il corretto funzionamento dell classe GameEngine, GameFactory, GameState, World , PlayerEntity e Point2d poichè consideriamo queste le classi più importanti del nostro progetto.
Di queste classi si testano :
- GameEngine
    - il costruttore 
    - le variabili statiche
- GameFactory
    - il costruttore
    - il metodo createPlayerEntity
    - il metodo createWorld
    - il metodo createTeleporter
    - il metodo createQuestPannel
- GameState
    - il costruttore
    - il metodo setWorld
    - la gestione del gameOver
    - il metodo notifyWorldEvent
- World
    - il costruttore
    - il metodo notifyWorldEvent
- PlayerEntity
    - il costruttore
    - il metodo addQuest
    - il metodo removeQuest
    - se il metodo getQuests ritorna una copia delle quest
    - controllo se i metodi desposit e withdraw funzionano correttamente
- Point2d
    - l'equals 
    - l'hashCode


### 2. Note di sviluppo

#### 2.1 Fabio Fattori Sviluppo

- Utilizzo di Stream:
    Usate in tutto il progetto per filtrare e mappare liste di GameObject o di Quest. Quello riportato è un singolo esempio presente nella classe GameEngine.
    Permalink: 

#### 2.2 Mattia Senni Sviluppo

#### 2.3 Francesco Tonelli Sviluppo

#### 2.4 Alessandro Buono Sviluppo

#### 2.5 Codice riadattato per la realizzazzione

Prima di metterci a lavorare sul progetto Fabio Fattori e Mattia Senni hanno partecipato al seminario opzionale 'Game as a Lab' , dove il Professore Ricci ha spiegato come realizzare un gioco in Java , in particolare ha spiegato come realizzare un gioco in Java con il pattern ECS mostrandoci un esempio di gioco realizzato da lui stesso, quel codice alla fine del seminario ci è stato consegnato e noi lo abbiamo riadattato per realizzare il nostro gioco.
Quindi difatto nel suo codice era presente una bozza di GameEngine , di World , di GameObject , di GraphicsComponent , di PhysicsComponent , di InputComponent , di Scene e di gestione degli eventi nel GameEngine , noi abbiamo preso queste bozze e le abbiamo riadattate per realizzare il progetto cercando ovviamente di capire il più possibile il codice che ci è stato consegnato.

# Commenti Finali 

### 1. Autovalutazione e Lavori Futuri 

#### 2.1 Fabio Fattori Autovalutazione

Penso di essere stato molto utile al gruppo , forse perchè ho partecipato al seminario opzionale 'Game as a Lab' , quindi ho avuto modo di capire meglio il codice che ci è stato consegnato e di capire meglio come funziona la struttura interna del gioco.
Quindi ero la figura nel gruppo a cui tutti si rivolgevano per chiedere chiarimenti su come funzionava il codice alla base del gioco, e per la risoluzione di bug; questo è accaduto anche perchè io sono riuscito a finire gli altri esami della sessione e quindi ho avuto più tempo per dedicarmi al progetto, dopo che ho finito le mie parti obbligatorie ho avuto modo anche di fare molte parti opzionali non richieste.
La vera difficoltà è stata realizzare la Camera , più precisamente far si che la camera seguisse il player , perchè la telecamera doveva seguire il player ma non doveva uscire dai bordi del mondo , quindi ho dovuto fare un sistema di traslazione della camera che mi permettesse di seguire il player ma che non mi facesse uscire dai bordi del mondo, infatti la parte della camera che gestisce questa cosa è abbastanza illeggibile da una persona che non ha scritto quella parte; quindi in futuro vorrei rifare la parte della camera per renderla più leggibile e più efficiente.

#### 2.2 Mattia Senni Autovalutazione

#### 2.3 Francesco Tonelli Autovalutazione

Ho lavorato principalmente alla parte grafica del progetto, dando supporto anche agli altri componenti del gruppo quando si è trattato di fare il resize di alcune interfacce in game. Purtroppo, sono stato un po' stretto coi tempi, a causa di impegni lavorativi e universitari, e quindi avrei preferito concentrarmi maggiormente su questo progetto, in quanto me ne sono sempre interessato, e l'idea mi era piaciuta molto già quando la stavamo valutando. Ho avuto modo di implementare cose che non avevo mai fatto, come grafiche più complesse di semplici bottoni, e le musiche di gioco, che per quanto il meccanismo sia piuttosto semplice mi ha incuriosito molto. In futuro, avrei voluto rifare da capo alcune grafiche, renderle più dettagliate e ottimizzate.
Le difficoltà più grandi che ho dovuto affrontare sono state sicuramente la scalabilità delle grafiche (nello specifico quella dell'hud, del fabbro e delle quest) e le animazioni dei personaggi, che sono costituite da più di uno sprite. A volte, durante lo sviluppo, dovevo attendere il completamento del codice di qualche altro componente per poter continuare con la mia parte, ma in fondo credo che quest'ultima difficoltà ci abbia solo portato ad avere più rispetto l'uno nei confronti dell'altro, e a lavorare come un team. 

#### 2.4 Alessandro Buono Autovalutazione

### 2. Difficoltà Incontrate e Commenti per i Docenti 


# Guida Utente 

# Movimento
- W per muoversi in alto
- S per muoversi in basso
- A per muoversi a sinistra
- D per muoversi a destra

# Interazione con gli oggetti
- E per interagire con un oggetto dopo essercisi avvicinato
- M per aprire e chiudere la minimappa
- J per aprire e chiudere il registro delle missioni
- I per aprire e chiudere l'inventario

# Combattimento
- freccette per attaccare nella direzione corrispondente alla freccetta premuta