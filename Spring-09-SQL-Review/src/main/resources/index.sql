EXPLAIN ANALYZE
SELECT *
FROM towns
WHERE name='0a6406c0e96397b3503951c98679c4e4';

CREATE INDEX idx_towns_name ON towns(name);

DROP INDEX IF EXISTS idx_towns_name;

SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;