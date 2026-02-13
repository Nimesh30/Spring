import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import StudentService from "../services/StudentService";
import { validateStudentForm } from "../services/validation";
import "../styles/StudentForm.css";


function StudentForm() {
  const navigate = useNavigate();
  const { id } = useParams(); // id present only for edit

  const [student, setStudent] = useState({
    firstName: "",
    lastName: "",
    email: "",
    dob: "",
    gender: "",
    admissionDate: "",
    className: "",
    city: "",
    stateCode: "",
    country: "",
  });

  useEffect(() => {
    if (id) {
      StudentService.getStudentById(id).then((res) => {
        setStudent({
          ...res.data,
          admissionDate: res.data.admissionDate?.split("T")[0],
        });
      });
    }
  }, [id]);

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const saveOrUpdateStudent = (e) => {
    e.preventDefault();

    if(!validateStudentForm(student)){
      return 
    }

    if (id) {
      StudentService.updateStudent(id, student)
        .then(() => navigate("/"))
        .catch((error) => {
          alert(error.response?.data?.message || "Email already exists....");
        });
    } else {
      StudentService.addStudent(student)
        .then(() => navigate("/"))
        .catch((error) => {
          alert(error.response?.data?.message || "Something went wrong");
        });
    }
  };
  return (
    <div className="form-container">
      <h2>{id ? "Edit Student" : "Add Student"}</h2>

      <form onSubmit={saveOrUpdateStudent}>
        <div className="form-group">
          <label>First Name</label>
          <input
            name="firstName"
            value={student.firstName}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label>Last Name</label>
          <input
            name="lastName"
            value={student.lastName}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={student.email}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label>Date of Birth</label>
          <input
            type="date"
            name="dob"
            value={student.dob}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label>Gender</label>
          <select
            name="gender"
            value={student.gender}
            onChange={handleChange}
            required
          >
            <option value="">Select Gender</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
          </select>
        </div>

        <div className="form-group">
          <label>Admission Date</label>
          <input
            type="date"
            name="admissionDate"
            value={student.admissionDate}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label>Class</label>
          <input
            name="className"
            value={student.className}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label>City</label>
          <input name="city" value={student.city} onChange={handleChange} />
        </div>

        <div className="form-group">
          <label>State Code</label>
          <input
            name="stateCode"
            value={student.stateCode}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label>Country</label>
          <input
            name="country"
            value={student.country}
            onChange={handleChange}
          />
        </div>

        <div className="button-group">
          <button type="submit" className="save">
            {id ? "Update" : "Save"}
          </button>
          <button
            type="button"
            className="cancel"
            onClick={() => navigate("/")}
          >
            Cancel
          </button>
        </div>
      </form>
    </div>
  );
}
<script src="../service/validation.js"></script>
export default StudentForm;
