import { useEffect, useState } from "react";
import StudentService from "../services/StudentService";
import { useNavigate } from "react-router-dom";

function StudentList() {
  const [students, setStudents] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    loadStudents();
  }, []);

  const loadStudents = () => {
    StudentService.getAllStudents().then((res) => setStudents(res.data));
  };

  const deleteStudent = (id) => {
    StudentService.deleteStudent(id).then(() => loadStudents());
  };

  return (
    <div>
      <button onClick={() => navigate("/add-student")}>➕ Add Student</button>

      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.firstName}</td>
              <td>{student.email}</td>
              <td>
                <button onClick={() => navigate(`/edit-student/${student.id}`)}>
                   Edit
                </button>
                <button onClick={() => deleteStudent(student.id)}>
                   Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;
