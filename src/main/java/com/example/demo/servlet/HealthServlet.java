@WebServlet(urlPatterns = "/health")
public class HealthServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.getWriter().write("OK");
    }
}
