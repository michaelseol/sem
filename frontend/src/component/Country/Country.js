import React from "react";
import { connect } from "react-redux";

const Country = ({ country }) => {
  return (
    <div className="country">
      <table className="responsive-table ">
        <thead>
          <tr>
            <th>#</th>
            <th>Code</th>
            <th>Name</th>
            <th>Continent</th>
            <th>Region</th>
            <th>Population</th>
            <th>Capital</th>
          </tr>
        </thead>

        <tbody>
          {country.map((c, index) => (
            <tr key={c.id}>
              <td>{++index}</td>
              <td>{c.code}</td>
              <td>{c.name}</td>
              <td>{c.continent}</td>
              <td>{c.region}</td>
              <td>{c.population}</td>
              <td>{c.capital}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
const mapStateToProps = (state) => ({
  country: state.country,
});

export default connect(mapStateToProps)(Country);
