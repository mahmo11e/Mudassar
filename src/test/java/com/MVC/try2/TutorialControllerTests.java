package com.MVC.try2;

import com.MVC.try2.controller.TutorialController;
import com.MVC.try2.model.Tutorial;
import com.MVC.try2.repository.TutorialRepository;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.description;
import static org.mockito.Mockito.when;

public class TutorialControllerTests {

    @InjectMocks
    TutorialController tutorialController;

    @Mock
    TutorialRepository mockTutorialRepository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTutorialsTest() {
        List<Tutorial> tutorialList = new ArrayList<Tutorial>();
        Tutorial tutorialOne = new Tutorial("Scott", "Brampton", false);
        Tutorial tutorialTwo = new Tutorial( "Clay", "Woodbridge", true);
        Tutorial tutorialThree = new Tutorial("Glen", "Queen", false);

        tutorialList.add(tutorialOne);
        tutorialList.add(tutorialTwo);
        tutorialList.add(tutorialThree);

        when(mockTutorialRepository.findAll()).thenReturn(tutorialList);

        ResponseEntity result = tutorialController.getAllTutorials() ;

        assertEquals(200, result.getStatusCode().value());
        assertTrue(result.getBody().equals(tutorialList));


    }
}
