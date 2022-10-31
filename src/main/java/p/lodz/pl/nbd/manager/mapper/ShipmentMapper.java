package p.lodz.pl.nbd.manager.mapper;

import static p.lodz.pl.nbd.manager.mapper.BoxMapper.toBoxes;
import static p.lodz.pl.nbd.manager.mapper.BoxMapper.toBoxesDocuments;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import p.lodz.pl.nbd.model.Locker;
import p.lodz.pl.nbd.model.Shipment;
import p.lodz.pl.nbd.persistance.document.shipment.LockerDocument;
import p.lodz.pl.nbd.persistance.document.shipment.ShipmentDocument;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class ShipmentMapper {

    public static List<Shipment> toShipments(List<ShipmentDocument> docs) {
        return docs.stream()
                .map(ShipmentMapper::toShipment)
                .collect(Collectors.toList());
    }

    public static Shipment toShipment(ShipmentDocument doc) {
        return Shipment.builder()
                .id(doc.getEntityId().getUuid())
                .boxes(toBoxes(doc.getBoxes()))
                .locker(toLocker(doc.getLocker()))
                .build();
    }

    private static Locker toLocker(final LockerDocument locker) {
        return Locker.builder()
                .empty(locker.getEmpty())
                .password(locker.getPassword())
                .build();
    }

    public static ShipmentDocument toShipmentDocument(Shipment shipment) {
        return ShipmentDocument.builder()
                .id(shipment.getId())
                .locker(toLockerDocument(shipment.getLocker()))
                .boxes(toBoxesDocuments(shipment.getBoxes()))
                .build();
    }

    private static LockerDocument toLockerDocument(final Locker locker) {
        return LockerDocument.builder()
                .empty(locker.getEmpty())
                .password(locker.getPassword())
                .build();
    }
}