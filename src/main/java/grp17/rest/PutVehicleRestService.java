package grp17.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class PutVehicleRestService {
    @GET

    public Response newVehicle(){
        return Response.status(200).entity("<html>\n" +
                "    <head>\n" +
                "        <title>Opret køretøj</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "    <label for=\"formVehiclePOST\"><strong>Data for oprettelse af nyt køretøj</strong></label>\n" +
                "    <form method=\"POST\" id=\"formVehiclePOST\">\n" +
                "        <label for=\"vehicle_license\">Nummerplade</label>\n" +
                "        <input type=\"number\" id=\"vehicle_license\" name=\"vehicle_license\"><br><br>\n" +
                "        <label for=\"vehicle_type\">Køretøjstype</label>\n" +
                "        <select name=\"vehicle_type\" id=\"vehicle_type\">\n" +
                "            <option value=\"autosprøjte\">Autosprøjte</option>\n" +
                "            <option value=\"stigvogn\">Stigvogn</option>\n" +
                "            <option value=\"personbil\">Personbil</option>\n" +
                "            <option value=\"containertrækker\">Containertrækker</option>\n" +
                "        </select>\n" +
                "        <br><br>\n" +
                "\n" +
                "        <label for=\"vehicle_purpose\">Køretøjsformål</label>\n" +
                "        <input type=\"text\" id=\"vehicle_purpose\" name=\"vehicle_purpose\"><br><br>\n" +
                "        <label for=\"unit_responsible\">Ansvarlige enhed</label>\n" +
                "        <input type=\"text\" id=\"unit_responsible\" name=\"unit_responsible\"><br><br>\n" +
                "        <input type=\"submit\" value=\"Opret Køretøj\">\n" +
                "    </form>\n" +
                "\n" +
                "    </body>\n" +
                "    <script>\n" +
                "        formVehiclePOST.onsubmit = async (e) => {\n" +
                "            e.preventDefault();\n" +
                "            var form = document.querySelector(\"#formVehiclePOST\");\n" +
                "            data = {\n" +
                "                license : form.querySelector('input[name=\"vehicle_license\"]').value,\n" +
                "                vehicle_type : form.querySelector('input[name=\"vehicle_type\"]').value,\n" +
                "                vehicle_purpose : form.querySelector('input[name=\"vehicle_purpose\"]').value,\n" +
                "                unit_responsible : form.querySelector('input[name=\"unit_responsible\"]').value\n" +
                "            }\n" +
                "\n" +
                "            var xmlhttp = new XMLHttpRequest();\n" +
                "            xmlhttp.open(\"POST\", \"http://localhost:8081/BrsREST_war_exploded/vehicles/new\");\n" +
                "            xmlhttp.setRequestHeader(\"Content-Type\", \"application/json\");\n" +
                "            xmlhttp.send(JSON.stringify(data));\n" +
                "\n" +
                "\n" +
                "\n" +
                "            /*\n" +
                "            let response = await fetch(\"grp17.mama.sh/BrsREST_war/vehicle/new\", {\n" +
                "                method: 'POST',\n" +
                "                headers: {\n" +
                "                    'Accept': 'application/json',\n" +
                "                    'Content-Type': 'application/json'\n" +
                "                },\n" +
                "                body: data\n" +
                "            });\n" +
                "            response.json().then(data =>{\n" +
                "                console.log(data);\n" +
                "            })\n" +
                "            */\n" +
                "        }\n" +
                "    </script>\n" +
                "</html>").build();
    }
}
