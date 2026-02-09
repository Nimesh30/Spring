import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import StudentService from "../services/StudentService";

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

    if (id) {
      StudentService.updateStudent(id, student).then(() => navigate("/"));
    } else {
      StudentService.addStudent(student).then(() => navigate("/"));
    }
  };

  return (
    <div>
      <h2>{id ? "Edit Student" : "Add Student"}</h2>

      <form onSubmit={saveOrUpdateStudent}>
        <input
          name="firstName"
          value={student.firstName}
          onChange={handleChange}
          placeholder="First Name"
          required
        />
        <input
          name="lastName"
          value={student.lastName}
          onChange={handleChange}
          placeholder="Last Name"
          required
        />
        <input
          type="email"
          name="email"
          value={student.email}
          onChange={handleChange}
          placeholder="Email"
          required
        />
        <input
          type="date"
          name="dob"
          value={student.dob}
          onChange={handleChange}
        />

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

        <input
          type="date"
          name="admissionDate"
          value={student.admissionDate}
          onChange={handleChange}
        />
        <input
          name="className"
          value={student.className}
          onChange={handleChange}
          placeholder="Class"
        />
        <input
          name="city"
          value={student.city}
          onChange={handleChange}
          placeholder="City"
        />
        <input
          name="stateCode"
          value={student.stateCode}
          onChange={handleChange}
          placeholder="State Code"
        />
        <input
          name="country"
          value={student.country}
          onChange={handleChange}
          placeholder="Country"
        />

        <button type="submit">{id ? "Update" : "Save"}</button>
        <button type="button" onClick={() => navigate("/")}>
          Cancel
        </button>
      </form>
    </div>
  );
}

export default StudentForm;
