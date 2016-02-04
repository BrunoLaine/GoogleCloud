package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.*;

public class Datastore extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		if (nom == null || prenom == null){
			//si pas d'infos sur le nouveau visiteur, afficher le formulaire
			getServletContext().getRequestDispatcher("/formulaireNomPrenom.jsp").forward(req, resp);
		}
		else {
			//ajoute le visiteur
			DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
			Query query = new Query("Personne");
			Transaction tx = dataStore.beginTransaction();
			Entity person = new Entity("Personne");
			person.setProperty("nom", nom);
			person.setProperty("prenom", prenom);
			dataStore.put(person);
			tx.commit();
			
			//récupère la liste des visiteurs
			List<String> noms = new ArrayList<String>();
			List<String> prenoms = new ArrayList<String>();
			PreparedQuery pq = dataStore.prepare(query);
			for(Entity e: pq.asIterable()){
				noms.add((String) e.getProperty("nom"));
				prenoms.add((String) e.getProperty("prenom"));
			}
			
			//affiche la liste
			req.setAttribute("prenoms", prenoms);
			req.setAttribute("noms", noms);
			getServletContext().getRequestDispatcher("/tableauVisiteurs.jsp").forward(req, resp);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
}
