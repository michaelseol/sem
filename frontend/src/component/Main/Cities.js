import React, { useState } from "react";
import { setCity } from "../../actions/city";
import { connect } from "react-redux";
import { useHistory } from "react-router-dom";
import axios from "axios";

const Cities = ({ setCity }) => {
  let history = useHistory();
  const [state, setstate] = useState({
    country: "",
    continent: "",
    region: "",
    n: 0,
  });
  const url = "http://localhost:8080/population";
  let { country, continent, region, n } = state;

  let config = {
    headers: {
      "Access-Control-Allow-Origin": "*",
    },
    params: {
      country: country,
      continent: continent,
      top: n,
      region: region,
    },
  };

  return (
    <div className="main">
      <div
        onClick={(e) => {
          axios.get(url + "/city/all").then((res) => {
            setCity(res.data);
            history.push("/city");
          });
        }}
        className="card-panel"
      >
        <h5>World Cities</h5>
      </div>

      <div
        onClick={(e) => {
          if (continent !== "")
            axios.get(`${url}/city/continent`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Cities in a Continent</h5>
        <div class="input-field">
          <input
            value={continent}
            onChange={(e) => setstate({ ...state, continent: e.target.value })}
            placeholder="Continent"
            type="text"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (country !== "")
            axios.get(`${url}/city/country`, config).then((res) => {
              setCity(res.data.reverse());

              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Cities in a Country</h5>
        <div class="input-field">
          <input
            value={country}
            onChange={(e) => setstate({ ...state, country: e.target.value })}
            placeholder="Country"
            type="text"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (n !== 0)
            axios.get(`${url}/city/top/world`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Top world Cities</h5>
        <div class="input-field">
          <input
            value={n}
            onChange={(e) => setstate({ ...state, n: e.target.value })}
            placeholder="n"
            type="number"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (n !== 0)
            axios.get(`${url}/city/top/continent/top`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Top in a Continent</h5>
        <div class="input-field">
          <input
            value={continent}
            onChange={(e) => setstate({ ...state, continent: e.target.value })}
            placeholder="Continent"
            type="text"
            class="validate"
          />
        </div>
        <div class="input-field">
          <input
            value={n}
            onChange={(e) => setstate({ ...state, n: e.target.value })}
            placeholder="n"
            type="number"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (n !== 0)
            axios.get(`${url}/city/top/country/top`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Top in a Country</h5>
        <div class="input-field">
          <input
            value={country}
            onChange={(e) => setstate({ ...state, country: e.target.value })}
            placeholder="Country"
            type="text"
            class="validate"
          />
        </div>
        <div class="input-field">
          <input
            value={n}
            onChange={(e) => setstate({ ...state, n: e.target.value })}
            placeholder="n"
            type="number"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          axios.get(url + "/capital/all").then((res) => {
            setCity(res.data);
            history.push("/city");
          });
        }}
        className="card-panel"
      >
        <h5>World Capital Cities</h5>
      </div>

      <div
        onClick={(e) => {
          if (continent !== "")
            axios.get(`${url}/capital/continent`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Capital Cities in a Continent</h5>
        <div class="input-field">
          <input
            value={continent}
            onChange={(e) => setstate({ ...state, continent: e.target.value })}
            placeholder="Continent"
            type="text"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (n !== 0)
            axios.get(`${url}/capital/top`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Top world Capital Cities</h5>
        <div class="input-field">
          <input
            value={n}
            onChange={(e) => setstate({ ...state, n: e.target.value })}
            placeholder="n"
            type="number"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (n !== 0)
            axios.get(`${url}/capital/top/continent`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Top Capital Cities in a Continent</h5>
        <div class="input-field">
          <input
            value={continent}
            onChange={(e) => setstate({ ...state, continent: e.target.value })}
            placeholder="Continent"
            type="text"
            class="validate"
          />
        </div>
        <div class="input-field">
          <input
            value={n}
            onChange={(e) => setstate({ ...state, n: e.target.value })}
            placeholder="n"
            type="number"
            class="validate"
          />
        </div>
      </div>
      <div
        onClick={(e) => {
          if (region !== "")
            axios.get(`${url}/capital/region`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Capital Cities in a Region</h5>
        <div class="input-field">
          <input
            value={region}
            onChange={(e) => setstate({ ...state, region: e.target.value })}
            placeholder="Region"
            type="text"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (region !== "")
            axios.get(`${url}/capital/region/top`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Top Capital Cities in a Region</h5>
        <div class="input-field">
          <input
            value={region}
            onChange={(e) => setstate({ ...state, region: e.target.value })}
            placeholder="Region"
            type="text"
            class="validate"
          />
        </div>
        <div class="input-field">
          <input
            value={n}
            onChange={(e) => setstate({ ...state, n: e.target.value })}
            placeholder="n"
            type="number"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (region !== "")
            axios.get(`${url}/country/region`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5> Cities in a Region</h5>
        <div class="input-field">
          <input
            value={region}
            onChange={(e) => setstate({ ...state, region: e.target.value })}
            placeholder="region"
            type="text"
            class="validate"
          />
        </div>
      </div>

      <div
        onClick={(e) => {
          if (region !== "")
            axios.get(`${url}/country/region/top`, config).then((res) => {
              setCity(res.data);
              history.push("/city");
            });
        }}
        className="card-panel"
      >
        <h5>Top Countries in a Region</h5>
        <div class="input-field">
          <input
            value={region}
            onChange={(e) => setstate({ ...state, region: e.target.value })}
            placeholder="Region"
            type="text"
            class="validate"
          />
        </div>
        <div class="input-field">
          <input
            value={n}
            onChange={(e) => setstate({ ...state, n: e.target.value })}
            placeholder="n"
            type="number"
            class="validate"
          />
        </div>
      </div>
    </div>
  );
};

export default connect(null, { setCity })(Cities);
