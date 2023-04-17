package com.back.about.common.service;

import com.back.about.book.domain.BookSeq;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@ComponentScan(basePackages={"com.back.about.common.service"})
public class SeqGeneratorService {

	private MongoOperations mongoOperations;

	public int generatorSeq(String seqName) {
		BookSeq counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seqNo", 1), options().returnNew(true).upsert(true), BookSeq.class);

		return !Objects.isNull(counter) ? counter.getSeqNo() : 1;
	}

}
