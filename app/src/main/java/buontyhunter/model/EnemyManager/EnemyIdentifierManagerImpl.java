package buontyhunter.model.EnemyManager;

public class EnemyIdentifierManagerImpl implements EnemyIdentifierManager {
    int currentIdentifier;

    public EnemyIdentifierManagerImpl() {
        this.currentIdentifier = 0;
    }

    @Override
    public int getIdentifier() {
        return ++currentIdentifier;
    }

    @Override
    public int getCurrentIdentifier() {
        return currentIdentifier;
    }

}
