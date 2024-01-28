package main.entities.help;

public abstract class EntityName {
    protected final String value;

    public EntityName(String value) {
        validate(value);
        this.value = normalize(value);
    }

    public String toString() {
        return value;
    }

    public boolean equals(Object other) {
        if(!other.getClass().equals(this.getClass())){
            return false;
        }
        return value.toString().equals(other.toString());
    }

    protected abstract void validate(String value);

    protected abstract String normalize(String value);
}
