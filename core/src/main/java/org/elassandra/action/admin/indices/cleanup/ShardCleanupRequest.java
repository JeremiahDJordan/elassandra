package org.elassandra.action.admin.indices.cleanup;

import java.io.IOException;

import org.elasticsearch.action.support.replication.ReplicationRequest;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.index.shard.ShardId;

public class ShardCleanupRequest extends ReplicationRequest<ShardCleanupRequest> {

    private CleanupRequest request = new CleanupRequest();

    public ShardCleanupRequest(CleanupRequest request, ShardId shardId) {
        super(shardId);
        this.request = request;
    }

    public ShardCleanupRequest() {
    }

    CleanupRequest getRequest() {
        return request;
    }

    @Override
    public void readFrom(StreamInput in) throws IOException {
        super.readFrom(in);
        request.readFrom(in);
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        super.writeTo(out);
        request.writeTo(out);
    }

    @Override
    public String toString() {
        return "cleanup {" + super.toString() + "}";
    }
}

