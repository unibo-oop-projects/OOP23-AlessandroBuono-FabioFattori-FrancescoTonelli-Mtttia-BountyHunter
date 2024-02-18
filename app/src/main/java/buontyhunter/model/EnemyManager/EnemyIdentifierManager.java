package buontyhunter.model.EnemyManager;

public interface EnemyIdentifierManager {
    /**
     * Get the next identifier
     * 
     * @return the next identifier
     */
    int getIdentifier();

    /**
     * Get the current identifier
     * 
     * @return the current identifier
     */
    int getCurrentIdentifier();
}
