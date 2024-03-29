package p.lodz.pl.nbd.model.box;

import java.util.UUID;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ENVELOPE")
@DiscriminatorValue("envelope")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Access(AccessType.FIELD)
public class Envelope extends BoxType {

    private int priority;

    @Builder
    public Envelope(UUID id, int length, int width, int height, int priority) {
        super(id, length, width, height);
        this.priority = priority;
    }

    @Override
    public double getCostModifier() {
        return 1d + Math.pow(2, priority + 1d);
    }
}
