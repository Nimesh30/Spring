import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import StudentService from "../services/StudentService";

function StudentList() {
  const navigate = useNavigate();

  const [students, setStudents] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  let newId=1;

  useEffect(() => {
    getAllStudents();
  }, []);

  //  Fetch all students
  const getAllStudents = () => {
    StudentService.getAllStudents().then((res) => {
      setStudents(res.data);
    });
  };

  //  Delete student
  const deleteStudent = (id) => {
    StudentService.deleteStudent(id).then(() => {
      getAllStudents();
    });
  };

  //  Calculate age 
  const calculateAge = (dob) => {
    if (!dob) return "";

    const birthDate = new Date(dob);
    const today = new Date();

    let years = today.getFullYear() - birthDate.getFullYear();
    let months = today.getMonth() - birthDate.getMonth();
    let days = today.getDate() - birthDate.getDate();

    if (days < 0) {
      months--;
      days += 30;
    }

    if (months < 0) {
      years--;
      months += 12;
    }

    const weeks = Math.floor(days / 7);

    return `${years} years ${months} months ${weeks} weeks`;
  };

  const getLocation = (student) => {
    return `${student.city}, ${student.stateCode}, ${student.country}`;
  };

  //  Search with name and email
  const filteredStudents = students.filter((student) =>
    `${student.firstName} ${student.lastName} ${student.email}`
      .toLowerCase()
      .includes(searchTerm.toLowerCase()),
  );

  return (
    <div className="container">
      <h2>Student List</h2>

      {/* Search */}
      <input
        type="text"
        placeholder="Search by name or email..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
        style={{
          width: "300px",
          padding: "8px",
          marginBottom: "15px",
        }}
      />

      <br />

      {/*  Add Student */}
      <button onClick={() => navigate("/add-student")}>Add Student</button>

      <table
        border="1"
        width="100%"
        cellPadding="10"
        style={{ marginTop: "15px" }}
      >
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Class</th>
            <th>Location</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {filteredStudents.length > 0 ? (
            filteredStudents.map((student) => (
              <tr key={student.id}>
                <td>{newId++}</td>
                <td>
                  {student.firstName} {student.lastName}
                </td>
                <td>{student.email}</td>
                <td>{calculateAge(student.dob)}</td>
                <td>{student.gender}</td>
                <td>{student.className}</td>
                <td>{getLocation(student)}</td>
                <td>
                  <button
                    onClick={() => navigate(`/edit-student/${student.id}`)}
                  >
                    Edit
                  </button>
                  <button
                    onClick={() => deleteStudent(student.id)}
                    style={{ marginLeft: "8px" }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="8" align="center">
                No students found
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;
