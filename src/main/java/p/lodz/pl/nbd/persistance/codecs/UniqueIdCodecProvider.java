package p.lodz.pl.nbd.persistance.codecs;


import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

import p.lodz.pl.nbd.persistance.document.UniqueIdMgd;

public class UniqueIdCodecProvider implements CodecProvider {

    @Override
    @SuppressWarnings("unchecked")
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry codecRegistry) {
        if (clazz == UniqueIdMgd.class) {
            return (Codec<T>) new UniqueIdCodec(codecRegistry);
        }
        //return null when there is no provider for the requested class
        return null;
    }

}