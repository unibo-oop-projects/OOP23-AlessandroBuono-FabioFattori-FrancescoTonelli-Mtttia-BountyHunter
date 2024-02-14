# Indice
1. [Analisi](#analisi)
    1. [Requisiti Funzionali](#requisiti)
    2. [Analisi e Modello del Dominio](#analisi-e-modello-del-dominio)
2. [Design](#design)
    1. [Architettura](#architettura)
    2. [Design dettagliato](#design-dettagliato)
3. [Sviluppo](#sviluppo)
    1. [Testing Automatizzato](#testing-automatizzato)
    2. [Note di sviluppo](#note-di-sviluppo)
    3. [Esempio](#esempio)
4. [Commenti Finali](#commenti-finali)
    1. [Autovalutazione e Lavori Futuri](#autovalutazione-e-lavori-futuri)
    2. [Difficoltà Incontrate e Commenti per i Docenti](#difficoltà-incontrate-e-commenti-per-i-docenti)
5. [Guida Utente](#guida-utente)

# Analisi <a name="analisi"></a>

Il software prevede di realizzare una simulazione delle avventure di un cacciatore di taglie, il giocatore prenderà i panni del protagonista, per simulazione si intende che il software dovrà consentire al giocatore di intraprendere missioni , guadagnare ricompense e migliorare il proprio equipaggiamento.

### 1. Requisiti <a name="requisiti"></a>
#### 1.1 Requisiti Funzionali
- Il software dovrà consentire la corretta visualizzazione di un mondo simulato , del giocatore , dei nemici e delle missioni.
- Inoltre il giocatore come i nemici si potranno muovere e attaccare all'interno del mondo simulato , il giocatore si muoverà tramite l'input da parte dell'utente mentre i nemici si muoveranno in modo autonomo.
- Il giocatore potrà attaccare i nemici e i nemici potranno attaccare il giocatore.
- Il software dovrà consentire la corretta visualizzazione di un HUD che mostri la vita, l'arma equipaggiata e i dobloni del giocatore; ed inoltre dovrà implementare un sistema di missioni e ricompense all'adempimento delle stesse.
- Il software dovrà anche fornire un interfaccia utente per la selezione dell'arma e per l'acquisto di nuove armi.

#### 1.2 Requisiti Non Funzionali
- Il software dovrà essere performante , in quanto dovrà essere in grado di gestire un numero elevato di entità all'interno del mondo simulato.
- Il software dovrà essere facilmente estendibile , in quanto dovrà essere possibile aggiungere nuove armi , nuovi nemici e nuove missioni senza dover modificare il codice alla base del gioco.

### 2. Analisi e Modello del Dominio <a name="analisi-e-modello-del-dominio"></a>

Il gioco sarà gestito secondo il modello MVC (Model-View-Controller) , il nostro controller dovrà permettere (uno alla volta) all'input di essere processato,alla fisica delle singole entità di essere aggiornata e alla grafica di essere disegnata. Tale Controller prenderà il nome di GameEngine e sarà il gestore/mediatore tra tutte le entità del gioco.
Ogni entità presente nel gioco prenderà il nome di GameObject e sarà composta da un componente che gestirà la fisica , un componente che gestirà la grafica,ed un componente che gestirà l'input.

# Design <a name="design"></a>

design

### 1. Architettura <a name="architettura"></a>

architettura

### 2. Design dettagliato <a name="design-dettagliato"></a>

design-dettagliato

# Sviluppo <a name="sviluppo"></a>

sviluppo

### 1. Testing Automatizzato <a name="testing-automatizzato"></a>

testing-automatizzato

### 2. Note di sviluppo <a name="note-di-sviluppo"></a>

note-di-sviluppo

### 3. Esempio <a name="esempio"></a>

esempio

# Commenti Finali <a name="commenti-finali"></a>

commenti-finali

### 1. Autovalutazione e Lavori Futuri <a name="autovalutazione-e-lavori-futuri"></a>

autovalutazione-e-lavori-futuri

### 2. Difficoltà Incontrate e Commenti per i Docenti <a name="difficoltà-incontrate-e-commenti-per-i-docenti"></a>

difficoltà-incontrate-e-commenti-per-i-docenti

# Guida Utente <a name="guida-utente"></a>

guida-utente