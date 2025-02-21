import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSignup = async (e) => {
    e.preventDefault();
  
    const userData = {
      username,
      password,
      role: "CONSUMER", // Default role
    };
  
    try {
        console.log(userData);
      const response = await axios.post("http://localhost:8080/auth/signup", userData, {
        headers: { "Content-Type": "application/json" },
      });
  
      console.log("User signed up successfully:", response.data);
      navigate("/login"); // Redirect to login page after successful signup
    } catch (err) {
      setError(err.response?.data || "Error during signup. Please try again.");
      console.error(err);
    }
  }

  return (
    <div className="container">
    <div className="center-container">
      <h2>Signup</h2>
      <form onSubmit={handleSignup}>
        <div className="mb-3">
          <label className="form-label">Username</label>
          <input
            type="text"
            className="form-control"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Password</label>
          <input
            type="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        {error && <p style={{ color: "red" }}>{error}</p>}
        <button type="submit" className="btn btn-primary">
          Sign Up
        </button>
      </form>
    </div>
    </div>
  );
};

export default Signup;
