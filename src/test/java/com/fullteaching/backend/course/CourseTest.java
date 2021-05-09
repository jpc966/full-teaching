package com.fullteaching.backend.course;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;

public class CourseTest {
    
    Course curso;
    User professor;
    CourseDetails detalhes;
    
    @BeforeEach
    void init() {
        this.professor = mock(User.class);
        this.detalhes = mock(CourseDetails.class);
        this.curso = new Course("Teste", "teste_imagem.jpg",  professor, detalhes);
    }
    
    @Test
    void testId() {
        assertNotNull(this.curso.getId());
        
        long novoId = 999;
        this.curso.setId(novoId);
        
        assertEquals(this.curso.getId(), novoId);
    }

    @Test
    void testTitle() {
        assertNotNull(this.curso.getTitle());
        
        String novoTitulo = "teste editado";
        this.curso.setTitle(novoTitulo);
        
        assertEquals(this.curso.getTitle(), novoTitulo);
    }
    
    @Test
    
    void testImage() {
        assertNotNull(this.curso.getImage());
        
        String novaImagem = "teste2.png";
        this.curso.setImage(novaImagem);
        
        assertEquals(this.curso.getImage(), novaImagem);        
    }
    
    @Test
    void testTeacher() {
        assertNotNull(this.curso.getTeacher());
        
        User novoProf = mock(User.class);
        this.curso.setTeacher(novoProf);
        
        assertEquals(this.curso.getTeacher(), novoProf);
    }
    
    @Test
    void testCourseDetails() {
        assertNotNull(this.curso.getCourseDetails());
        
        CourseDetails novosDetalhes = mock(CourseDetails.class);
        this.curso.setCourseDetails(novosDetalhes);
        
        assertEquals(this.curso.getCourseDetails(), novosDetalhes);
    }
    
    @Test
    void testAttenders() {
        assertNotNull(this.curso.getAttenders());
        
        Set<User> attenders;
        attenders = new HashSet<User>();
        attenders.add(mock(User.class));
        attenders.add(mock(User.class));
        
        this.curso.setAttenders(attenders);
        
        assertEquals(this.curso.getAttenders(), attenders);        
    }
    
    @Test
    void testSessions() {
        assertNotNull(this.curso.getSessions());
        
        Set<Session> sessions;
        sessions = new HashSet<Session>();
        sessions.add(mock(Session.class));
        sessions.add(mock(Session.class));
        
        this.curso.setSessions(sessions);
        
        assertEquals(this.curso.getSessions(), sessions);
    }
    
    @Test
    void testToString() {
        Set<User> attenders;
        attenders = new HashSet<User>();
        attenders.add(mock(User.class));
        attenders.add(mock(User.class));
        this.curso.setAttenders(attenders);
        Set<Session> sessions;
        sessions = new HashSet<Session>();
        sessions.add(mock(Session.class));
        sessions.add(mock(Session.class));
        this.curso.setSessions(sessions);
        String string = "Course[title: \"Teste\", teacher: \"null\", #attenders: 2, #sessions: 2]";
        assertEquals(this.curso.toString(), string);
    }
}