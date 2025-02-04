import { describe, it, expect } from 'vitest'
import { fizzbuzz } from '../../functions/1-types'

describe('fizzbuzz (UNION RETURN TYPE)', () => {
  it('retourne une chaîne de caractères lorsque le paramètres est divisible par 3 et/ou 5', () => {
    expect(typeof fizzbuzz(3)).toBe('string')
    expect(typeof fizzbuzz(5)).toBe('string')
    expect(typeof fizzbuzz(15)).toBe('string')
  })

  it('retourne un nombre lorsque le paramètres n\'est pas divisible par 3 et/ou 5', () => {
    expect(typeof fizzbuzz(1)).toBe('number')
    expect(typeof fizzbuzz(2)).toBe('number')
    expect(typeof fizzbuzz(4)).toBe('number')
  })

  it('retourne la réponse correcte ou le nombre originel', () => {
    expect(fizzbuzz(1)).toBe(1)
    expect(fizzbuzz(2)).toBe(2)
    expect(fizzbuzz(3)).toBe('fizz')
    expect(fizzbuzz(5)).toBe('buzz')
    expect(fizzbuzz(7)).toBe(7)
    expect(fizzbuzz(11)).toBe(11)
    expect(fizzbuzz(15)).toBe('fizzbuzz')
  })
})
