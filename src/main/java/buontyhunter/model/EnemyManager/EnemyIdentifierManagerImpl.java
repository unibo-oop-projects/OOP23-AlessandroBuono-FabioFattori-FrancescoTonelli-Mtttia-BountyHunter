package buontyhunter.model.EnemyManager;

/**
 * The enemy identifier manager
 */
public class EnemyIdentifierManagerImpl implements EnemyIdentifierManager {
    int currentIdentifier;

    /**
     * Create a new enemy identifier manager
     */
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
