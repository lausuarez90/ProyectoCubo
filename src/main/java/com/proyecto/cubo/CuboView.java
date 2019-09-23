package com.proyecto.cubo;

import com.proyecto.cubo.ImpInterface.ImpInterfaceCubo;
import com.proyecto.cubo.interfaces.InterfaceCubo;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;


@CDIView(CuboView.NAME)
public class CuboView extends CustomComponent implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InterfaceCubo interfaceCube;
	public final static String NAME = "";
	
	public CuboView() {		
		
    	interfaceCube = new ImpInterfaceCubo();
    			
		final VerticalLayout layout = new VerticalLayout();
        
        Panel panel = new Panel("Problem");
        panel.setSizeUndefined();
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();        
        
        Label name = new Label();
        name.setCaption("Cube Problem!!!");
        name.setHeight("120px");
        name.addStyleName("mycaption");
        
        TextArea problem = new TextArea();
        Button btnEjecutar = new Button("Ejecutar"); 
        TextArea respond = new TextArea();
        
        btnEjecutar.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				String problema = problem.getValue();
				String respuesta = interfaceCube.ejecutarOperacion(problema);
				respond.setValue(respuesta);				
			}
		});
        
        
        horizontalLayout.addComponent(problem);
        horizontalLayout.addComponent(btnEjecutar);
        horizontalLayout.addComponent(respond);
        
        panel.setContent(horizontalLayout);
        
        HorizontalLayout horizontal = new HorizontalLayout();
        horizontal.addComponent(name);
               
        layout.addComponent(horizontal);
        layout.setComponentAlignment(horizontal, Alignment.MIDDLE_CENTER);
        layout.addComponent(panel);
        layout.setComponentAlignment(panel, Alignment.TOP_CENTER);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setCompositionRoot(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
