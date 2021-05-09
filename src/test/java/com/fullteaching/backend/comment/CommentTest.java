package com.fullteaching.backend.comment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.user.User;

public class CommentTest {

	User user;

	Comment comentario;
	Comment comentario_pai;
	Comment comentario_filho;

	@BeforeEach
	void init() {
		this.user = mock(User.class);

		this.comentario =  new Comment();
		this.comentario_pai =  new Comment("mensagem comentario pai", 07052021, this.user);
		this.comentario_filho =  new Comment("mensagem comentario filho", 07052021, this.user, comentario_pai);
	}

	@Test
	void testId() {
		assertNotNull(this.comentario.getId());
		long novoId = 57859394;
		this.comentario.setId(novoId);

		assertEquals(novoId, this.comentario.getId());
	}

	@Test
	void testMessage() {
		assertNotNull(this.comentario_pai.getMessage());

		String novaMensagem = "messagem comentario pai editada";
		this.comentario_pai.setMessage(novaMensagem);

		assertEquals(novaMensagem, this.comentario_pai.getMessage());
	}

	@Test
	void testDate() {
		assertNotNull(this.comentario_pai.getDate());

		long novaData = 4052021;
		this.comentario_pai.setDate(novaData);

		assertEquals(novaData, this.comentario_pai.getDate());
	}

	@Test
	void testReplies() {
		assertNotNull(this.comentario_pai.getReplies());

		Comment reply = new Comment("resposta comentario mensagem commentario pai", 04052021, this.user);
		List<Comment> replies = new ArrayList<Comment>();
		replies.add(reply);
		this.comentario_pai.setReplies(replies);

		assertEquals(replies, this.comentario_pai.getReplies());
	}

	@Test
	void testUser() {
		assertNotNull(this.comentario_pai.getUser());

		User novoUsuario = mock(User.class);
		this.comentario_pai.setUser(novoUsuario);

		assertEquals(novoUsuario, this.comentario_pai.getUser());
	}

	@Test
	void testCommentParent() {
		assertNotNull(this.comentario_filho.getCommentParent());

		this.comentario_pai.setCommentParent(comentario);
		assertEquals(this.comentario, this.comentario_pai.getCommentParent());
	}

	@Test
	void testToString() {		
		String string1 = "Comment[message: \"null\", author: \"\", parent: \"null\", #replies: 0date: \"0\"]";
		String string2 = "Comment[message: \"mensagem comentario pai\", author: \"null\", parent: \"null\", #replies: 0date: \"1856529\"]";
		String string3 = "Comment[message: \"mensagem comentario filho\", author: \"null\", parent: \"mensagem comentario pai\", #replies: 0date: \"1856529\"]";

		assertEquals(string1, this.comentario.toString());
		assertEquals(string2, this.comentario_pai.toString());
		assertEquals(string3, this.comentario_filho.toString());
	}

}