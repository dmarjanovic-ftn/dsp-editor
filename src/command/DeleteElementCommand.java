package command;

import java.util.ArrayList;

import model.Component;
import model.Link;
import model.Schema;
import model.Terminal;

public class DeleteElementCommand implements Command {
	
	private Schema model;
	// Cuvamo listu indeksa obrisanih komponenti
	private ArrayList<Integer> deletedComponents;
	// Cuvamo listu indeksa obrisanih veza
	private ArrayList<Integer> deletedLinks;
	
	public DeleteElementCommand(Schema model, ArrayList<Integer> components) {
		this.model = model;
		this.deletedComponents = components;
		deletedLinks = new ArrayList<Integer>();
	}

	@Override
	public void execute() {
		//int p = 0;
		
		for (Integer index: deletedComponents) {
			
			Component component = model.components.get(index);
			
			// Za svaku komponentu brisemo njene veze, a oslobadjamo terminal sa druge strane veze
			if (component != null) {
				for (Terminal term : component.terminals) {
					for (Link link : model.links) {
						if (link.dest != null && link.dest == term) {
							if (link.src != null){
								link.src.setConnected(false);
							}
							
							this.deletedLinks.add(model.links.indexOf(link));
							link.status = false;
							break;
						}

						if (link.src != null && link.src == term) {
							if (link.dest != null){
								link.dest.setConnected(false);
							}
							
							this.deletedLinks.add(model.links.indexOf(link));
							link.status = false;
							break;
						}

						/*
						if (p == 2){
							System.out.println("Ispunjeno");
							break;
						}
						*/
					}
				}
				
				component.status = false;
			}
		}
		
		model.notifyAllObservers();
	}

	@Override
	public void unexecute() {
		model.selectedComponents.clear();
		
		// Vracamo obrisane komponente da budu vidljive
		for (Integer index: deletedComponents) {
			Component comp = model.components.get(index);
			comp.status = true;
			model.selectedComponents.add(comp);
		}
		
		// Za svaku vezu zauzimamo terminale na njenim krajevima
		for (Integer index: deletedLinks) {
			Link link = model.links.get(index);
			link.status = true;
			link.dest.setConnected(true);
			link.src.setConnected(true);
		}
		
		model.notifyAllObservers();

	}

}
