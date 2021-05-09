package com.fullteaching.backend.forum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.entry.Entry;

public class ForumTest {

	Forum forum;
	List<Entry> topicos;
	Entry topico1, topico2, topico3;


	@BeforeEach
	void init() {
		this.forum = new Forum();
		this.topicos = new ArrayList<>();
		this.topico1 = mock(Entry.class);
		this.topico2 = mock(Entry.class);
		this.topico3 = mock(Entry.class);
		this.topicos.add(topico1);
		this.forum.setEntries(topicos);
	}

	@Test
	void testId() {
		assertNotNull(this.forum.getId());

		long novoId = 999;
		this.forum.setId(novoId);

		assertEquals(this.forum.getId(), novoId);
	}

	@Test
	void testActivated() {
		assertNotNull(this.forum.isActivated());
		boolean activated = false;
		this.forum.setActivated(activated);
		assertEquals(this.forum.isActivated(), activated);
		activated = true;
		this.forum.setActivated(activated);
		assertEquals(this.forum.isActivated(), activated);

	}

	@Test
	void testEntries() {
		this.topicos.add(this.topico1);
		this.topicos.add(this.topico2);
		this.topicos.add(this.topico3);

		assertNotNull(this.forum.getEntries());

		this.forum.setEntries(topicos);
		assertEquals(this.forum.getEntries(), topicos);
	}

	@Test
	void testToString() {

		String string = "Forum[activated: \"false\", #entries: \"1\", #comments: \"0\"]";
		assertEquals(this.forum.toString(), string);
	}

}